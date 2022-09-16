package com.dogoo.common.files.manager.service.retriver;

import com.dogoo.common.files.manager.service.mapper.model.FileManagerMapperModel;
import org.osgi.annotation.versioning.ProviderType;

import java.util.List;

/**
 * @author ba trung
 * @see DGFileManagerRetriever
 * @generated
 */
@ProviderType
public interface DGFileManagerRetriever {

    /**
     * Returns ALL the file manager mapper model where  customerId and classPkId , classPkName , pkType;.
     *
     * @param customerId the customer ID
     * @param parentCode the parent code
     * @param pkType the parent type
     * @return the matching DG File Manager of customer , parent , parent type
     */
    List<FileManagerMapperModel> getAllDGFileManagerByPKType(long customerId ,
                                                             String parentCode ,
                                                             String pkType);
    /**
     * Returns the employee career mapper model where employeeId = &#63 and customerId;.
     *
     * @param customerId the customer ID
     * @param parentCode the parent code
     * @return the matching employee is department , jobPosition , jobTitle current
     */
    List<Long> getAllFileId(long customerId ,
                            String parentCode );

    /**
     * Returns ALL the file manager mapper model where  customerId and classPkId , classPkName;.
     *
     * @param customerId the customer ID
     * @param parentCode the parent code
     * @return the matching DG File Manager of customer , parent , parent type
     */
    List<FileManagerMapperModel> getAllDGFileManager(long customerId ,
                                                     String parentCode );

}
