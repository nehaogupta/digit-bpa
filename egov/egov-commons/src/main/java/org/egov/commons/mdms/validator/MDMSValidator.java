package org.egov.commons.mdms.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.egov.common.entity.dcr.helper.ErrorDetail;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.jayway.jsonpath.JsonPath;

@Service
public class MDMSValidator {

    private static final Logger LOG = Logger.getLogger(MDMSValidator.class);

    public List<ErrorDetail> validateMdmsData(Map<String, List<String>> masterData, Map<String, String> data) {

        List<ErrorDetail> errors = new ArrayList<>();

        String[] masterArray = { "ApplicationType", "ServiceType" };
        validateIfMasterPresent(masterArray, masterData, errors);

        if (!masterData.get("ApplicationType").contains(data.get("applicationType")))
            errors.add(new ErrorDetail("INVALID APPLICATIONTYPE", "The applicationType '" + data.get("applicationType") +
                    "' does not exists"));

        return errors;
    }

    public Map<String, List<String>> getAttributeValues(Object mdmsData) {

        List<String> modulepaths = Arrays.asList("$.MdmsRes.BPA");
        final Map<String, List<String>> mdmsResMap = new HashMap<>();
        modulepaths.forEach(modulepath -> {
            try {
                mdmsResMap.putAll(JsonPath.read(mdmsData, modulepath));
            } catch (Exception e) {
                LOG.error("Error while fetching MDMS data", e);
            }
        });
        return mdmsResMap;
    }

    /**
     * Validates if MasterData is properly fetched for the given MasterData names
     * 
     * @param masterNames
     * @param codes
     */

    private List<ErrorDetail> validateIfMasterPresent(String[] masterNames, Map<String, List<String>> codes,
            List<ErrorDetail> errors) {
        for (String masterName : masterNames) {
            if (CollectionUtils.isEmpty(codes.get(masterName))) {
                errors.add(new ErrorDetail("MDMS DATA ERROR ", "Unable to fetch " + masterName + " codes from MDMS"));
                ;
            }
        }
        return errors;
    }

}