/*
 * eGov suite of products aim to improve the internal efficiency,transparency,
 *    accountability and the service delivery of the government  organizations.
 *
 *     Copyright (C) <2015>  eGovernments Foundation
 *
 *     The updated version of eGov suite of products as by eGovernments Foundation
 *     is available at http://www.egovernments.org
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program. If not, see http://www.gnu.org/licenses/ or
 *     http://www.gnu.org/licenses/gpl.html .
 *
 *     In addition to the terms of the GPL license to be adhered to in using this
 *     program, the following additional terms are to be complied with:
 *
 *         1) All versions of this program, verbatim or modified must carry this
 *            Legal Notice.
 *
 *         2) Any misrepresentation of the origin of the material is prohibited. It
 *            is required that all modified versions of this material be marked in
 *            reasonable ways as different from the original version.
 *
 *         3) This license does not grant any rights to any user of the program
 *            with regards to rights under trademark law for use of the trade names
 *            or trademarks of eGovernments Foundation.
 *
 *   In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
 */
package org.egov.bpa.web.controller.transaction;

import static org.egov.infra.utils.StringUtils.append;
import static org.springframework.http.MediaType.APPLICATION_PDF_VALUE;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.egov.bpa.transaction.entity.PermitInspection;
import org.egov.bpa.transaction.entity.common.DocketDetailCommon;
import org.egov.bpa.transaction.entity.enums.ScrutinyChecklistType;
import org.egov.bpa.transaction.notice.InspectionReportFormat;
import org.egov.bpa.transaction.notice.impl.InspectionReportFormatImpl;
import org.egov.bpa.transaction.service.InspectionService;
import org.egov.bpa.transaction.service.oc.PlanScrutinyChecklistCommonService;
import org.egov.infra.custom.CustomImplProvider;
import org.egov.infra.reporting.engine.ReportOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/application")
public class ViewInspectionController {
    private static final String PERMIT_INSPECTION = "permitInspection";

    private static final String SHOW_INSPECTION_DETAILS = "show-inspection-details";

    private static final String INSPECTION_RESULT = "inspection-details-result";
    private static final String INLINE_FILENAME = "inline;filename=";
    private static final String CONTENT_DISPOSITION = "content-disposition";
    private static final String PDFEXTN = ".pdf";

    @Autowired
    private InspectionService inspectionService;
    @Autowired
    private PlanScrutinyChecklistCommonService planScrutinyChecklistService;
    @Autowired
    private CustomImplProvider specificNoticeService;

    @GetMapping("/view-inspection/{id}")
    public String viewInspection(@PathVariable final Long id, final Model model) {
        final List<PermitInspection> permitInspn = inspectionService.findByIdOrderByIdAsc(id);
        List<DocketDetailCommon> dockeDetList = new ArrayList<>();
        if (!permitInspn.isEmpty())
            dockeDetList = permitInspn.get(0).getInspection().getDocket().get(0).getDocketDetail();
        model.addAttribute("docketDetail", dockeDetList);
        PermitInspection inspectionObj = permitInspn.get(0);
        model.addAttribute(PERMIT_INSPECTION, inspectionObj);
        model.addAttribute("message", "Inspection Saved Successfully");
        final InspectionService inspectionService = (InspectionService) specificNoticeService
                .find(InspectionService.class, specificNoticeService.getCityDetails());
       // inspectionService.buildDocketDetailForModifyAndViewList(inspectionObj, model);
        inspectionService.prepareImagesForView(inspectionObj);
        model.addAttribute(PERMIT_INSPECTION, inspectionObj);
        inspectionService.buildPlanScrutinyChecklistDetails(inspectionObj);
        return INSPECTION_RESULT;
    }

    @GetMapping("/showinspectiondetails/{id}")
    public String showInspectionDetails(@PathVariable final Long id, final Model model) {
        final List<PermitInspection> permitInspn = inspectionService.findByIdOrderByIdAsc(id);
        List<DocketDetailCommon> dockeDetList = new ArrayList<>();
        if (!permitInspn.isEmpty())
            dockeDetList = permitInspn.get(0).getInspection().getDocket().get(0).getDocketDetail();
        model.addAttribute("docketDetail", dockeDetList);
        PermitInspection inspectionObj = permitInspn.get(0);
        final InspectionService inspectionService = (InspectionService) specificNoticeService
                .find(InspectionService.class, specificNoticeService.getCityDetails());
        inspectionService.buildDocketDetailForModifyAndViewList(inspectionObj, model);
        inspectionService.prepareImagesForView(inspectionObj);
        model.addAttribute(PERMIT_INSPECTION, inspectionObj);
        inspectionService.buildPlanScrutinyChecklistDetails(inspectionObj);
        return SHOW_INSPECTION_DETAILS;
    }

    @GetMapping(value = "/inspectionreport", produces = APPLICATION_PDF_VALUE)
    @ResponseBody
    public ResponseEntity<InputStreamResource> generateLettertoPartyCreate(final HttpServletRequest request,
            final HttpSession session) {
        final PermitInspection inspection = inspectionService.findById(new Long(request.getParameter("pathVar")));
        InspectionReportFormat inspectionReportFormat = (InspectionReportFormat) specificNoticeService
                .find(InspectionReportFormatImpl.class, specificNoticeService.getCityDetails());
        return getFileAsResponseEntity(inspection.getInspection().getInspectionNumber(),
                inspectionReportFormat.generateNotice(inspection),
                "inspectionreport");
    }

    private ResponseEntity<InputStreamResource> getFileAsResponseEntity(String inspectionNumber, ReportOutput reportOutput,
            String prefixFileName) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_PDF)
                .cacheControl(CacheControl.noCache())
                .contentLength(reportOutput.getReportOutputData().length)
                .header(CONTENT_DISPOSITION, String.format(INLINE_FILENAME,
                        append(prefixFileName, inspectionNumber) + PDFEXTN))
                .body(new InputStreamResource(reportOutput.asInputStream()));
    }

}
