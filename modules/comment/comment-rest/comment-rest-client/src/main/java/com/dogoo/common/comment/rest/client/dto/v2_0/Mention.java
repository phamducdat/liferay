package com.dogoo.common.comment.rest.client.dto.v2_0;

import com.dogoo.common.comment.rest.client.function.UnsafeSupplier;
import com.dogoo.common.comment.rest.client.serdes.v2_0.MentionSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author khoa
 * @generated
 */
@Generated("")
public class Mention implements Cloneable, Serializable {

	public static Mention toDTO(String json) {
		return MentionSerDes.toDTO(json);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long id;

	public String getMentionChar() {
		return mentionChar;
	}

	public void setMentionChar(String mentionChar) {
		this.mentionChar = mentionChar;
	}

	public void setMentionChar(
		UnsafeSupplier<String, Exception> mentionCharUnsafeSupplier) {

		try {
			mentionChar = mentionCharUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String mentionChar;

	@Override
	public Mention clone() throws CloneNotSupportedException {
		return (Mention)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Mention)) {
			return false;
		}

		Mention mention = (Mention)object;

		return Objects.equals(toString(), mention.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return MentionSerDes.toJSON(this);
	}

}