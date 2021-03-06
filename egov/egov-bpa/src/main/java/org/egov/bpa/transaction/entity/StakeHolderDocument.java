/**
 * eGov suite of products aim to improve the internal efficiency,transparency,
   accountability and the service delivery of the government  organizations.
    Copyright (C) <2015>  eGovernments Foundation
    The updated version of eGov suite of products as by eGovernments Foundation
    is available at http://www.egovernments.org
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    any later version.
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program. If not, see http://www.gnu.org/licenses/ or
    http://www.gnu.org/licenses/gpl.html .
    In addition to the terms of the GPL license to be adhered to in using this
    program, the following additional terms are to be complied with:
        1) All versions of this program, verbatim or modified must carry this
           Legal Notice.
        2) Any misrepresentation of the origin of the material is prohibited. It
           is required that all modified versions of this material be marked in
           reasonable ways as different from the original version.
        3) This license does not grant any rights to any user of the program
           with regards to rights under trademark law for use of the trade names
           or trademarks of eGovernments Foundation.
  In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
 */
package org.egov.bpa.transaction.entity;

import java.util.Collections;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.egov.bpa.master.entity.CheckListDetail;
import org.egov.bpa.master.entity.StakeHolder;
import org.egov.infra.filestore.entity.FileStoreMapper;
import org.egov.infra.persistence.entity.AbstractAuditable;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "EGBPA_STAKEHOLDER_Document", schema = "state")
@SequenceGenerator(name = StakeHolderDocument.SEQ_STAKEHOLDER_DOCUMENT, sequenceName = StakeHolderDocument.SEQ_STAKEHOLDER_DOCUMENT, allocationSize = 1, schema = "state")
public class StakeHolderDocument extends AbstractAuditable {

    private static final long serialVersionUID = 3078684328383202788L;
    public static final String SEQ_STAKEHOLDER_DOCUMENT = "SEQ_EGBPA_STAKEHOLDER_Document";
    @Id
    @GeneratedValue(generator = SEQ_STAKEHOLDER_DOCUMENT, strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "checklistdetail")
    private CheckListDetail checkListDetail;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stakeHolder")
    private StakeHolder stakeHolder;
    private Boolean isAttached;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "egbpa_stakeholder_support_documents", schema = "state", joinColumns = @JoinColumn(name = "stakeholderdocumentid"), inverseJoinColumns = @JoinColumn(name = "filestoreid"))
    private Set<FileStoreMapper> supportDocs = Collections.emptySet();
    private transient MultipartFile[] files;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    protected void setId(final Long id) {
        this.id = id;
    }

    public StakeHolder getStakeHolder() {
        return stakeHolder;
    }

    public void setStakeHolder(final StakeHolder stakeHolder) {
        this.stakeHolder = stakeHolder;
    }

    public Boolean getIsAttached() {
        return isAttached;
    }

    public void setIsAttached(final Boolean isAttached) {
        this.isAttached = isAttached;
    }

    public CheckListDetail getCheckListDetail() {
        return checkListDetail;
    }

    public void setCheckListDetail(final CheckListDetail checkListDetail) {
        this.checkListDetail = checkListDetail;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    public Set<FileStoreMapper> getSupportDocs() {
        return supportDocs;
    }

    public void setSupportDocs(Set<FileStoreMapper> supportDocs) {
        this.supportDocs = supportDocs;
    }

}