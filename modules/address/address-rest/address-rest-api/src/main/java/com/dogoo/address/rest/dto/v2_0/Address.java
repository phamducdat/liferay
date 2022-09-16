package com.dogoo.address.rest.dto.v2_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author datdt
 * @generated
 */
@Generated("")
@GraphQLName(description = "Present address of object", value = "Address")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Address")
public class Address implements Serializable {

	public static Address toDTO(String json) {
		return ObjectMapperUtil.readValue(Address.class, json);
	}

	public static Address unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Address.class, json);
	}

	@Schema(description = "The Address country.")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@JsonIgnore
	public void setCountry(
		UnsafeSupplier<String, Exception> countryUnsafeSupplier) {

		try {
			country = countryUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The Address country.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String country;

	@Schema(description = "The Address country Code.")
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@JsonIgnore
	public void setCountryCode(
		UnsafeSupplier<String, Exception> countryCodeUnsafeSupplier) {

		try {
			countryCode = countryCodeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The Address country Code.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String countryCode;

	@Schema(description = "The Address detail.")
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@JsonIgnore
	public void setDetail(
		UnsafeSupplier<String, Exception> detailUnsafeSupplier) {

		try {
			detail = detailUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The Address detail.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String detail;

	@Schema(description = "The Address district.")
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@JsonIgnore
	public void setDistrict(
		UnsafeSupplier<String, Exception> districtUnsafeSupplier) {

		try {
			district = districtUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The Address district.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String district;

	@Schema(description = "The Address district Code.")
	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	@JsonIgnore
	public void setDistrictCode(
		UnsafeSupplier<String, Exception> districtCodeUnsafeSupplier) {

		try {
			districtCode = districtCodeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The Address district Code.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String districtCode;

	@Schema
	public String getExternalReferenceCode() {
		return externalReferenceCode;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		this.externalReferenceCode = externalReferenceCode;
	}

	@JsonIgnore
	public void setExternalReferenceCode(
		UnsafeSupplier<String, Exception> externalReferenceCodeUnsafeSupplier) {

		try {
			externalReferenceCode = externalReferenceCodeUnsafeSupplier.get();
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
	protected String externalReferenceCode;

	@Schema(description = "The Address ID.")
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

	@GraphQLField(description = "The Address ID.")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long id;

	@Schema(description = "The postal code detail.")
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@JsonIgnore
	public void setPostalCode(
		UnsafeSupplier<String, Exception> postalCodeUnsafeSupplier) {

		try {
			postalCode = postalCodeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The postal code detail.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String postalCode;

	@Schema(description = "The Address province.")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@JsonIgnore
	public void setProvince(
		UnsafeSupplier<String, Exception> provinceUnsafeSupplier) {

		try {
			province = provinceUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The Address province.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String province;

	@Schema(description = "The Address province Code.")
	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	@JsonIgnore
	public void setProvinceCode(
		UnsafeSupplier<String, Exception> provinceCodeUnsafeSupplier) {

		try {
			provinceCode = provinceCodeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The Address province Code.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String provinceCode;

	@Schema(description = "The title of address")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonIgnore
	public void setTitle(
		UnsafeSupplier<String, Exception> titleUnsafeSupplier) {

		try {
			title = titleUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The title of address")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String title;

	@Schema(description = "The Address ward.")
	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	@JsonIgnore
	public void setWard(UnsafeSupplier<String, Exception> wardUnsafeSupplier) {
		try {
			ward = wardUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The Address ward.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String ward;

	@Schema(description = "The Address ward Code.")
	public String getWardCode() {
		return wardCode;
	}

	public void setWardCode(String wardCode) {
		this.wardCode = wardCode;
	}

	@JsonIgnore
	public void setWardCode(
		UnsafeSupplier<String, Exception> wardCodeUnsafeSupplier) {

		try {
			wardCode = wardCodeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The Address ward Code.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String wardCode;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Address)) {
			return false;
		}

		Address address = (Address)object;

		return Objects.equals(toString(), address.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (country != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"country\": ");

			sb.append("\"");

			sb.append(_escape(country));

			sb.append("\"");
		}

		if (countryCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"countryCode\": ");

			sb.append("\"");

			sb.append(_escape(countryCode));

			sb.append("\"");
		}

		if (detail != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"detail\": ");

			sb.append("\"");

			sb.append(_escape(detail));

			sb.append("\"");
		}

		if (district != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"district\": ");

			sb.append("\"");

			sb.append(_escape(district));

			sb.append("\"");
		}

		if (districtCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"districtCode\": ");

			sb.append("\"");

			sb.append(_escape(districtCode));

			sb.append("\"");
		}

		if (externalReferenceCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(externalReferenceCode));

			sb.append("\"");
		}

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
		}

		if (postalCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"postalCode\": ");

			sb.append("\"");

			sb.append(_escape(postalCode));

			sb.append("\"");
		}

		if (province != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"province\": ");

			sb.append("\"");

			sb.append(_escape(province));

			sb.append("\"");
		}

		if (provinceCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"provinceCode\": ");

			sb.append("\"");

			sb.append(_escape(provinceCode));

			sb.append("\"");
		}

		if (title != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(title));

			sb.append("\"");
		}

		if (ward != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"ward\": ");

			sb.append("\"");

			sb.append(_escape(ward));

			sb.append("\"");
		}

		if (wardCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"wardCode\": ");

			sb.append("\"");

			sb.append(_escape(wardCode));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.dogoo.address.rest.dto.v2_0.Address",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
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
			sb.append(entry.getKey());
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
				sb.append(value);
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

}