package com.dogoo.common.comment.rest.client.dto.v2_0;

import com.dogoo.common.comment.rest.client.function.UnsafeSupplier;
import com.dogoo.common.comment.rest.client.serdes.v2_0.EmoticonSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author khoa
 * @generated
 */
@Generated("")
public class Emoticon implements Cloneable, Serializable {

	public static Emoticon toDTO(String json) {
		return EmoticonSerDes.toDTO(json);
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

	public Long getCretorUserId() {
		return cretorUserId;
	}

	public void setCretorUserId(Long cretorUserId) {
		this.cretorUserId = cretorUserId;
	}

	public void setCretorUserId(
		UnsafeSupplier<Long, Exception> cretorUserIdUnsafeSupplier) {

		try {
			cretorUserId = cretorUserIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long cretorUserId;

	public String getEmoji() {
		return emoji;
	}

	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}

	public void setEmoji(
		UnsafeSupplier<String, Exception> emojiUnsafeSupplier) {

		try {
			emoji = emojiUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String emoji;

	public Long getEmoticonId() {
		return emoticonId;
	}

	public void setEmoticonId(Long emoticonId) {
		this.emoticonId = emoticonId;
	}

	public void setEmoticonId(
		UnsafeSupplier<Long, Exception> emoticonIdUnsafeSupplier) {

		try {
			emoticonId = emoticonIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long emoticonId;

	@Override
	public Emoticon clone() throws CloneNotSupportedException {
		return (Emoticon)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Emoticon)) {
			return false;
		}

		Emoticon emoticon = (Emoticon)object;

		return Objects.equals(toString(), emoticon.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return EmoticonSerDes.toJSON(this);
	}

}