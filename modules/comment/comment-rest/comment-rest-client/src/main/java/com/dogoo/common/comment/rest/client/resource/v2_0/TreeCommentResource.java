package com.dogoo.common.comment.rest.client.resource.v2_0;

import com.dogoo.common.comment.rest.client.dto.v2_0.TreeComment;
import com.dogoo.common.comment.rest.client.http.HttpInvoker;
import com.dogoo.common.comment.rest.client.pagination.Page;
import com.dogoo.common.comment.rest.client.problem.Problem;
import com.dogoo.common.comment.rest.client.serdes.v2_0.TreeCommentSerDes;

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
public interface TreeCommentResource {

	public static Builder builder() {
		return new Builder();
	}

	public Page<TreeComment> getAllTreeComment(
			Long classPkId, String classPkName, Integer pageSize)
		throws Exception;

	public HttpInvoker.HttpResponse getAllTreeCommentHttpResponse(
			Long classPkId, String classPkName, Integer pageSize)
		throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public TreeCommentResource build() {
			return new TreeCommentResourceImpl(this);
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

	public static class TreeCommentResourceImpl implements TreeCommentResource {

		public Page<TreeComment> getAllTreeComment(
				Long classPkId, String classPkName, Integer pageSize)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getAllTreeCommentHttpResponse(classPkId, classPkName, pageSize);

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
				return Page.of(content, TreeCommentSerDes::toDTO);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse getAllTreeCommentHttpResponse(
				Long classPkId, String classPkName, Integer pageSize)
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

			if (classPkId != null) {
				httpInvoker.parameter("classPkId", String.valueOf(classPkId));
			}

			if (classPkName != null) {
				httpInvoker.parameter(
					"classPkName", String.valueOf(classPkName));
			}

			if (pageSize != null) {
				httpInvoker.parameter("pageSize", String.valueOf(pageSize));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/dogoo/comment-rest/v2.0/tree-comments");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private TreeCommentResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Logger _logger = Logger.getLogger(
			TreeCommentResource.class.getName());

		private Builder _builder;

	}

}