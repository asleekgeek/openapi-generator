/*
 * OpenAPI Petstore
 *
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


using Polly;
using System.Net.Http;

namespace Org.OpenAPITools.Client
{
    /// <summary>
    /// Configuration class to set the polly retry policies to be applied to the requests.
    /// </summary>
    public static class RetryConfiguration
    {
        /// <summary>
        /// Retry policy
        /// </summary>
        public static Policy<HttpResponseMessage> RetryPolicy { get; set; }

        /// <summary>
        /// Async retry policy
        /// </summary>
        public static AsyncPolicy<HttpResponseMessage> AsyncRetryPolicy { get; set; }
    }
}
