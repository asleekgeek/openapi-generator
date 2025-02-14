/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.apis

import java.io.IOException
import okhttp3.Call
import okhttp3.HttpUrl

import org.openapitools.client.models.Environment

import com.squareup.moshi.Json

import org.openapitools.client.infrastructure.ApiClient
import org.openapitools.client.infrastructure.ApiResponse
import org.openapitools.client.infrastructure.ClientException
import org.openapitools.client.infrastructure.ClientError
import org.openapitools.client.infrastructure.ServerException
import org.openapitools.client.infrastructure.ServerError
import org.openapitools.client.infrastructure.MultiValueMap
import org.openapitools.client.infrastructure.PartConfig
import org.openapitools.client.infrastructure.RequestConfig
import org.openapitools.client.infrastructure.RequestMethod
import org.openapitools.client.infrastructure.ResponseType
import org.openapitools.client.infrastructure.Success
import org.openapitools.client.infrastructure.toMultiValue

class FakeApi(basePath: kotlin.String = defaultBasePath, client: Call.Factory = ApiClient.defaultClient) : ApiClient(basePath, client) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "http://localhost")
        }
    }

    /**
     * GET /fake/parameter-name-mapping
     * parameter name mapping test
     * 
     * @param underscoreType _type
     * @param type type
     * @param typeWithUnderscore type_
     * @param httpDebugOption http debug option (to test parameter naming option)
     * @return Environment
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun getParameterNameMapping(underscoreType: kotlin.Long, type: kotlin.String, typeWithUnderscore: kotlin.String, httpDebugOption: kotlin.String) : Environment {
        val localVarResponse = getParameterNameMappingWithHttpInfo(underscoreType = underscoreType, type = type, typeWithUnderscore = typeWithUnderscore, httpDebugOption = httpDebugOption)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as Environment
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * GET /fake/parameter-name-mapping
     * parameter name mapping test
     * 
     * @param underscoreType _type
     * @param type type
     * @param typeWithUnderscore type_
     * @param httpDebugOption http debug option (to test parameter naming option)
     * @return ApiResponse<Environment?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun getParameterNameMappingWithHttpInfo(underscoreType: kotlin.Long, type: kotlin.String, typeWithUnderscore: kotlin.String, httpDebugOption: kotlin.String) : ApiResponse<Environment?> {
        val localVariableConfig = getParameterNameMappingRequestConfig(underscoreType = underscoreType, type = type, typeWithUnderscore = typeWithUnderscore, httpDebugOption = httpDebugOption)

        return request<Unit, Environment>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation getParameterNameMapping
     *
     * @param underscoreType _type
     * @param type type
     * @param typeWithUnderscore type_
     * @param httpDebugOption http debug option (to test parameter naming option)
     * @return RequestConfig
     */
    fun getParameterNameMappingRequestConfig(underscoreType: kotlin.Long, type: kotlin.String, typeWithUnderscore: kotlin.String, httpDebugOption: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
            .apply {
                put("type", listOf(type.toString()))
                put("http_debug_option", listOf(httpDebugOption.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        underscoreType.apply { localVariableHeaders["_type"] = this.toString() }
        typeWithUnderscore.apply { localVariableHeaders["type_"] = this.toString() }
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/fake/parameter-name-mapping",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }


    private fun encodeURIComponent(uriComponent: kotlin.String): kotlin.String =
        HttpUrl.Builder().scheme("http").host("localhost").addPathSegment(uriComponent).build().encodedPathSegments[0]
}
