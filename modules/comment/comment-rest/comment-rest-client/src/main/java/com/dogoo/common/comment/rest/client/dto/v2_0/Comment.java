package com.dogoo.common.comment.rest.client.dto.v2_0;

import com.dogoo.common.comment.rest.client.function.UnsafeSupplier;
import com.dogoo.common.comment.rest.client.serdes.v2_0.CommentSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author khoa
 * @generated
 */
@Generated("")
public class Comment implements Cloneable, Serializable {

	public static Comment toDTO(String json) {
		return CommentSerDes.toDTO(json);
	}

	public Long getClassPkId() {
		return classPkId;
	}

	public void setClassPkId(Long classPkId) {
		this.classPkId = classPkId;
	}

	public void setClassPkId(
		UnsafeSupplier<Long, Exception> classPkIdUnsafeSupplier) {

		try {
			classPkId = classPkIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long classPkId;

	public String getClassPkName() {
		return classPkName;
	}

	public void setClassPkName(String classPkName) {
		this.classPkName = classPkName;
	}

	public void setClassPkName(
		UnsafeSupplier<String, Exception> classPkNameUnsafeSupplier) {

		try {
			classPkName = classPkNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String classPkName;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public void setCommentId(
		UnsafeSupplier<Long, Exception> commentIdUnsafeSupplier) {

		try {
			commentId = commentIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long commentId;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setContent(
		UnsafeSupplier<String, Exception> contentUnsafeSupplier) {

		try {
			content = contentUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String content;

	public String getCreateDateNow() {
		return createDateNow;
	}

	public void setCreateDateNow(String createDateNow) {
		this.createDateNow = createDateNow;
	}

	public void setCreateDateNow(
		UnsafeSupplier<String, Exception> createDateNowUnsafeSupplier) {

		try {
			createDateNow = createDateNowUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String createDateNow;

	public Long getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(Long creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public void setCreatorUserId(
		UnsafeSupplier<Long, Exception> creatorUserIdUnsafeSupplier) {

		try {
			creatorUserId = creatorUserIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long creatorUserId;

	public String getCreatorUserName() {
		return creatorUserName;
	}

	public void setCreatorUserName(String creatorUserName) {
		this.creatorUserName = creatorUserName;
	}

	public void setCreatorUserName(
		UnsafeSupplier<String, Exception> creatorUserNameUnsafeSupplier) {

		try {
			creatorUserName = creatorUserNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String creatorUserName;

	public String getExternalReferenceCode() {
		return externalReferenceCode;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		this.externalReferenceCode = externalReferenceCode;
	}

	public void setExternalReferenceCode(
		UnsafeSupplier<String, Exception> externalReferenceCodeUnsafeSupplier) {

		try {
			externalReferenceCode = externalReferenceCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String externalReferenceCode;

	public Mention[] getMentions() {
		return mentions;
	}

	public void setMentions(Mention[] mentions) {
		this.mentions = mentions;
	}

	public void setMentions(
		UnsafeSupplier<Mention[], Exception> mentionsUnsafeSupplier) {

		try {
			mentions = mentionsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Mention[] mentions;

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public void setParentId(
		UnsafeSupplier<Long, Exception> parentIdUnsafeSupplier) {

		try {
			parentId = parentIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long parentId;

	@Override
	public Comment clone() throws CloneNotSupportedException {
		return (Comment)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Comment)) {
			return false;
		}

		Comment comment = (Comment)object;

		return Objects.equals(toString(), comment.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CommentSerDes.toJSON(this);
	}

}