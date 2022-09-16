package com.dogoo.common.files.manager.rest.dto.v2_0;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author khoa
 * @generated
 */
@Generated("")
@GraphQLName(description = "upload docuemnt", value = "DGDocumentManager")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "DGDocumentManager")
public class DGDocumentManager implements Serializable {

	public static DGDocumentManager toDTO(String json) {
		return ObjectMapperUtil.readValue(DGDocumentManager.class, json);
	}

	public static DGDocumentManager unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(DGDocumentManager.class, json);
	}

	@Schema
	@Valid
	public Category getCategory() {
		return category;
	}

	@JsonIgnore
	public String getCategoryAsString() {
		if (category == null) {
			return null;
		}

		return category.toString();
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@JsonIgnore
	public void setCategory(
		UnsafeSupplier<Category, Exception> categoryUnsafeSupplier) {

		try {
			category = categoryUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Category category;

	@Schema
	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	@JsonIgnore
	public void setCreatorId(
		UnsafeSupplier<Long, Exception> creatorIdUnsafeSupplier) {

		try {
			creatorId = creatorIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long creatorId;

	@Schema
	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	@JsonIgnore
	public void setCreatorName(
		UnsafeSupplier<String, Exception> creatorNameUnsafeSupplier) {

		try {
			creatorName = creatorNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String creatorName;

	@Schema
	public String getDownloadPath() {
		return downloadPath;
	}

	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}

	@JsonIgnore
	public void setDownloadPath(
		UnsafeSupplier<String, Exception> downloadPathUnsafeSupplier) {

		try {
			downloadPath = downloadPathUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String downloadPath;

	@Schema
	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@JsonIgnore
	public void setExtension(
		UnsafeSupplier<String, Exception> extensionUnsafeSupplier) {

		try {
			extension = extensionUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String extension;

	@Schema
	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	@JsonIgnore
	public void setFileId(
		UnsafeSupplier<Long, Exception> fileIdUnsafeSupplier) {

		try {
			fileId = fileIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long fileId;

	@Schema
	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	@JsonIgnore
	public void setFileSize(
		UnsafeSupplier<String, Exception> fileSizeUnsafeSupplier) {

		try {
			fileSize = fileSizeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String fileSize;

	@Schema(description = "id of the file in the dlfileentry table.")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "id of the file in the dlfileentry table.")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long id;

	@Schema
	public Boolean getIsPrivate() {
		return isPrivate;
	}

	public void setIsPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	@JsonIgnore
	public void setIsPrivate(
		UnsafeSupplier<Boolean, Exception> isPrivateUnsafeSupplier) {

		try {
			isPrivate = isPrivateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Boolean isPrivate;

	@Schema
	@Valid
	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	@JsonIgnore
	public void setMetadata(
		UnsafeSupplier<Metadata, Exception> metadataUnsafeSupplier) {

		try {
			metadata = metadataUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Metadata metadata;

	@Schema
	public String getMineType() {
		return mineType;
	}

	public void setMineType(String mineType) {
		this.mineType = mineType;
	}

	@JsonIgnore
	public void setMineType(
		UnsafeSupplier<String, Exception> mineTypeUnsafeSupplier) {

		try {
			mineType = mineTypeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String mineType;

	@Schema
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@JsonIgnore
	public void setModifiedDate(
		UnsafeSupplier<Date, Exception> modifiedDateUnsafeSupplier) {

		try {
			modifiedDate = modifiedDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Date modifiedDate;

	@Schema
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String name;

	@Schema
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@JsonIgnore
	public void setParentId(
		UnsafeSupplier<Long, Exception> parentIdUnsafeSupplier) {

		try {
			parentId = parentIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long parentId;

	@Schema
	@Valid
	public Path[] getPaths() {
		return paths;
	}

	public void setPaths(Path[] paths) {
		this.paths = paths;
	}

	@JsonIgnore
	public void setPaths(
		UnsafeSupplier<Path[], Exception> pathsUnsafeSupplier) {

		try {
			paths = pathsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Path[] paths;

	@Schema
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@JsonIgnore
	public void setPermission(
		UnsafeSupplier<String, Exception> permissionUnsafeSupplier) {

		try {
			permission = permissionUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String permission;

	@Schema
	public String getPkCode() {
		return pkCode;
	}

	public void setPkCode(String pkCode) {
		this.pkCode = pkCode;
	}

	@JsonIgnore
	public void setPkCode(
		UnsafeSupplier<String, Exception> pkCodeUnsafeSupplier) {

		try {
			pkCode = pkCodeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String pkCode;

	@Schema
	public String getPreviewPath() {
		return previewPath;
	}

	public void setPreviewPath(String previewPath) {
		this.previewPath = previewPath;
	}

	@JsonIgnore
	public void setPreviewPath(
		UnsafeSupplier<String, Exception> previewPathUnsafeSupplier) {

		try {
			previewPath = previewPathUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String previewPath;

	@Schema
	@Valid
	public SettingPermission getRole() {
		return role;
	}

	public void setRole(SettingPermission role) {
		this.role = role;
	}

	@JsonIgnore
	public void setRole(
		UnsafeSupplier<SettingPermission, Exception> roleUnsafeSupplier) {

		try {
			role = roleUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected SettingPermission role;

	@Schema
	@Valid
	public SharedObjectBrief[] getSharedObjectBriefs() {
		return sharedObjectBriefs;
	}

	public void setSharedObjectBriefs(SharedObjectBrief[] sharedObjectBriefs) {
		this.sharedObjectBriefs = sharedObjectBriefs;
	}

	@JsonIgnore
	public void setSharedObjectBriefs(
		UnsafeSupplier<SharedObjectBrief[], Exception>
			sharedObjectBriefsUnsafeSupplier) {

		try {
			sharedObjectBriefs = sharedObjectBriefsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected SharedObjectBrief[] sharedObjectBriefs;

	@Schema
	@Valid
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@JsonIgnore
	public void setTask(UnsafeSupplier<Task, Exception> taskUnsafeSupplier) {
		try {
			task = taskUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Task task;

	@Schema
	@Valid
	public Type getType() {
		return type;
	}

	@JsonIgnore
	public String getTypeAsString() {
		if (type == null) {
			return null;
		}

		return type.toString();
	}

	public void setType(Type type) {
		this.type = type;
	}

	@JsonIgnore
	public void setType(UnsafeSupplier<Type, Exception> typeUnsafeSupplier) {
		try {
			type = typeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Type type;

	@Schema
	@Valid
	public UploadFileInfo getUploadDiffInfo() {
		return uploadDiffInfo;
	}

	public void setUploadDiffInfo(UploadFileInfo uploadDiffInfo) {
		this.uploadDiffInfo = uploadDiffInfo;
	}

	@JsonIgnore
	public void setUploadDiffInfo(
		UnsafeSupplier<UploadFileInfo, Exception>
			uploadDiffInfoUnsafeSupplier) {

		try {
			uploadDiffInfo = uploadDiffInfoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected UploadFileInfo uploadDiffInfo;

	@Schema
	@Valid
	public UploadFileInfo getUploadFilesInfo() {
		return uploadFilesInfo;
	}

	public void setUploadFilesInfo(UploadFileInfo uploadFilesInfo) {
		this.uploadFilesInfo = uploadFilesInfo;
	}

	@JsonIgnore
	public void setUploadFilesInfo(
		UnsafeSupplier<UploadFileInfo, Exception>
			uploadFilesInfoUnsafeSupplier) {

		try {
			uploadFilesInfo = uploadFilesInfoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected UploadFileInfo uploadFilesInfo;

	@Schema
	@Valid
	public UploadFileInfo getUploadImageInfo() {
		return uploadImageInfo;
	}

	public void setUploadImageInfo(UploadFileInfo uploadImageInfo) {
		this.uploadImageInfo = uploadImageInfo;
	}

	@JsonIgnore
	public void setUploadImageInfo(
		UnsafeSupplier<UploadFileInfo, Exception>
			uploadImageInfoUnsafeSupplier) {

		try {
			uploadImageInfo = uploadImageInfoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected UploadFileInfo uploadImageInfo;

	@Schema
	@Valid
	public UploadFileInfo getUploadMediaInfo() {
		return uploadMediaInfo;
	}

	public void setUploadMediaInfo(UploadFileInfo uploadMediaInfo) {
		this.uploadMediaInfo = uploadMediaInfo;
	}

	@JsonIgnore
	public void setUploadMediaInfo(
		UnsafeSupplier<UploadFileInfo, Exception>
			uploadMediaInfoUnsafeSupplier) {

		try {
			uploadMediaInfo = uploadMediaInfoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected UploadFileInfo uploadMediaInfo;

	@Schema
	@Valid
	public UploadFileInfo getUploadTextInfo() {
		return uploadTextInfo;
	}

	public void setUploadTextInfo(UploadFileInfo uploadTextInfo) {
		this.uploadTextInfo = uploadTextInfo;
	}

	@JsonIgnore
	public void setUploadTextInfo(
		UnsafeSupplier<UploadFileInfo, Exception>
			uploadTextInfoUnsafeSupplier) {

		try {
			uploadTextInfo = uploadTextInfoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected UploadFileInfo uploadTextInfo;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DGDocumentManager)) {
			return false;
		}

		DGDocumentManager dgDocumentManager = (DGDocumentManager)object;

		return Objects.equals(toString(), dgDocumentManager.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (category != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"category\": ");

			sb.append("\"");

			sb.append(category);

			sb.append("\"");
		}

		if (creatorId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creatorId\": ");

			sb.append(creatorId);
		}

		if (creatorName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creatorName\": ");

			sb.append("\"");

			sb.append(_escape(creatorName));

			sb.append("\"");
		}

		if (downloadPath != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"downloadPath\": ");

			sb.append("\"");

			sb.append(_escape(downloadPath));

			sb.append("\"");
		}

		if (extension != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"extension\": ");

			sb.append("\"");

			sb.append(_escape(extension));

			sb.append("\"");
		}

		if (fileId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileId\": ");

			sb.append(fileId);
		}

		if (fileSize != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileSize\": ");

			sb.append("\"");

			sb.append(_escape(fileSize));

			sb.append("\"");
		}

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
		}

		if (isPrivate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isPrivate\": ");

			sb.append(isPrivate);
		}

		if (metadata != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"metadata\": ");

			sb.append(String.valueOf(metadata));
		}

		if (mineType != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mineType\": ");

			sb.append("\"");

			sb.append(_escape(mineType));

			sb.append("\"");
		}

		if (modifiedDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modifiedDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(modifiedDate));

			sb.append("\"");
		}

		if (name != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(name));

			sb.append("\"");
		}

		if (parentId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentId\": ");

			sb.append(parentId);
		}

		if (paths != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"paths\": ");

			sb.append("[");

			for (int i = 0; i < paths.length; i++) {
				sb.append(String.valueOf(paths[i]));

				if ((i + 1) < paths.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (permission != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"permission\": ");

			sb.append("\"");

			sb.append(_escape(permission));

			sb.append("\"");
		}

		if (pkCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"pkCode\": ");

			sb.append("\"");

			sb.append(_escape(pkCode));

			sb.append("\"");
		}

		if (previewPath != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"previewPath\": ");

			sb.append("\"");

			sb.append(_escape(previewPath));

			sb.append("\"");
		}

		if (role != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"role\": ");

			sb.append(String.valueOf(role));
		}

		if (sharedObjectBriefs != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"sharedObjectBriefs\": ");

			sb.append("[");

			for (int i = 0; i < sharedObjectBriefs.length; i++) {
				sb.append(String.valueOf(sharedObjectBriefs[i]));

				if ((i + 1) < sharedObjectBriefs.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (task != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"task\": ");

			sb.append(String.valueOf(task));
		}

		if (type != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(type);

			sb.append("\"");
		}

		if (uploadDiffInfo != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"uploadDiffInfo\": ");

			sb.append(String.valueOf(uploadDiffInfo));
		}

		if (uploadFilesInfo != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"uploadFilesInfo\": ");

			sb.append(String.valueOf(uploadFilesInfo));
		}

		if (uploadImageInfo != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"uploadImageInfo\": ");

			sb.append(String.valueOf(uploadImageInfo));
		}

		if (uploadMediaInfo != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"uploadMediaInfo\": ");

			sb.append(String.valueOf(uploadMediaInfo));
		}

		if (uploadTextInfo != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"uploadTextInfo\": ");

			sb.append(String.valueOf(uploadTextInfo));
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.dogoo.common.files.manager.rest.dto.v2_0.DGDocumentManager",
		name = "x-class-name"
	)
	public String xClassName;

	@GraphQLName("Category")
	public static enum Category {

		PERSONAL("personal"), ATTACHED("attached"), COMPANY("company");

		@JsonCreator
		public static Category create(String value) {
			if ((value == null) || value.equals("")) {
				return null;
			}

			for (Category category : values()) {
				if (Objects.equals(category.getValue(), value)) {
					return category;
				}
			}

			throw new IllegalArgumentException("Invalid enum value: " + value);
		}

		@JsonValue
		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private Category(String value) {
			_value = value;
		}

		private final String _value;

	}

	@GraphQLName("Type")
	public static enum Type {

		FOLDER("folder"), FILE("file");

		@JsonCreator
		public static Type create(String value) {
			if ((value == null) || value.equals("")) {
				return null;
			}

			for (Type type : values()) {
				if (Objects.equals(type.getValue(), value)) {
					return type;
				}
			}

			throw new IllegalArgumentException("Invalid enum value: " + value);
		}

		@JsonValue
		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private Type(String value) {
			_value = value;
		}

		private final String _value;

	}

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}