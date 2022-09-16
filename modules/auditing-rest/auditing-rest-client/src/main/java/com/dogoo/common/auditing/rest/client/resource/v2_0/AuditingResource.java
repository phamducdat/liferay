package com.dogoo.common.auditing.rest.client.resource.v2_0;

import com.dogoo.common.auditing.rest.client.dto.v2_0.Auditing;
import com.dogoo.common.auditing.rest.client.http.HttpInvoker;
import com.dogoo.common.auditing.rest.client.pagination.Page;
import com.dogoo.common.auditing.rest.client.problem.Problem;
import com.dogoo.common.auditing.rest.client.serdes.v2_0.AuditingSerDes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author khoa
 * @generated
 */
@Generated("")
public interface AuditingResource {

	public static Builder builder() {
		return new Builder();
	}

	public Page<Auditing> getAuditings(
			Long classPkId, String classPkName, java.util.Date startDate,
			java.util.Date endDate, String filterString)
		throws Exception;

	public HttpInvoker.HttpResponse getAuditingsHttpResponse(
			Long classPkId, String classPkName, java.util.Date startDate,
			java.util.Date endDate, String filterString)
		throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public AuditingResource build() {
			return new AuditingResourceImpl(this);
		}

		public Builder endpoint(String host, int port, String scheme) {
			_host = host;
			_port = port;
			_scheme = scheme;

			return this;
		}

		public Builder header(String key, String value) {
			_headers.put(key, value);

			return this;
		}

		public Builder locale(Locale locale) {
			_locale = locale;

			return this;
		}

		public Builder parameter(String key, String value) {
			_parameters.put(key, value);

			return this;
		}

		public Builder parameters(String... parameters) {
			if ((parameters.length % 2) != 0) {
				throw new IllegalArgumentException(
					"Parameters length is not an even number");
			}

			for (int i = 0; i < parameters.length; i += 2) {
				String parameterName = String.valueOf(parameters[i]);
				String parameterValue = String.valueOf(parameters[i + 1]);

				_parameters.put(parameterName, parameterValue);
			}

			return this;
		}

		private Builder() {
		}

		private Map<String, String> _headers = new LinkedHashMap<>();
		private String _host = "localhost";
		private Locale _locale;
		private String _login = "";
		private String _password = "";
		private Map<String, String> _parameters = new LinkedHashMap<>();
		private int _port = 8080;
		private String _scheme = "http";

	}

	public static class AuditingResourceImpl implements AuditingResource {

		public Page<Auditing> getAuditings(
				Long classPkId, String classPkName, java.util.Date startDate,
				java.util.Date endDate, String filterString)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse = getAuditingsHttpResponse(
				classPkId, classPkName, startDate, endDate, filterString);

			String content = httpResponse.getContent();

			if ((httpResponse.getStatusCode() / 100) != 2) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response content: " + content);
				_logger.log(
					Level.WARNING,
					"HTTP response message: " + httpResponse.getMessage());
				_logger.log(
					Level.WARNING,
					"HTTP response status code: " +
						httpResponse.getStatusCode());

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
			else {
				_logger.fine("HTTP response content: " + content);
				_logger.fine(
					"HTTP response message: " + httpResponse.getMessage());
				_logger.fine(
					"HTTP response status code: " +
						httpResponse.getStatusCode());
			}

			try {
				return Page.of(content, AuditingSerDes::toDTO);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse getAuditingsHttpResponse(
				Long classPkId, String classPkName, java.util.Date startDate,
				java.util.Date endDate, String filterString)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss'Z'");

			if (classPkId != null) {
				httpInvoker.parameter("classPkId", String.valueOf(classPkId));
			}

			if (classPkName != null) {
				httpInvoker.parameter(
					"classPkName", String.valueOf(classPkName));
			}

			if (startDate != null) {
				httpInvoker.parameter(
					"startDate", liferayToJSONDateFormat.format(startDate));
			}

			if (endDate != null) {
				httpInvoker.parameter(
					"endDate", liferayToJSONDateFormat.format(endDate));
			}

			if (filterString != null) {
				httpInvoker.parameter("filter", filterString);
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port + "/o/dogoo/auditing-rest/v2.0/auditings");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private AuditingResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Logger _logger = Logger.getLogger(
			AuditingResource.class.getName());

		private Builder _builder;

	}

}