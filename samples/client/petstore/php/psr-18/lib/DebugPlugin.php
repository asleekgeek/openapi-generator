<?php
/**
 * Configuration
 * PHP version 7.2
 *
 * @category Class
 * @package  OpenAPI\Client
 * @author   OpenAPI Generator team
 * @link     https://openapi-generator.tech
 */

/**
 * OpenAPI Petstore
 *
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://openapi-generator.tech
 * Generator version: 7.12.0-SNAPSHOT
 */

/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

namespace OpenAPI\Client;

use Http\Client\Common\Plugin;
use Http\Promise\Promise;
use Psr\Http\Client\ClientExceptionInterface;
use Psr\Http\Message\RequestInterface;
use Psr\Http\Message\ResponseInterface;
use function is_resource;

/**
 * Configuration Class Doc Comment
 * PHP version 7.2
 *
 * @category Class
 * @package  OpenAPI\Client
 * @author   OpenAPI Generator team
 * @link     https://openapi-generator.tech
 */
class DebugPlugin implements Plugin
{

    /**
     * @var resource
     */
    private $output;

    /**
     * DebuggingPlugin constructor.
     *
     * @param resource $output
     */
    public function __construct($output)
    {
        if (!is_resource($output)) {
            throw new \InvalidArgumentException('debugging resource is not valid');
        }
        $this->output = $output;
    }

    public function handleRequest(RequestInterface $request, callable $next, callable $first): Promise
    {
        return $next($request)->then(
            function (ResponseInterface $response) use ($request) {
                $this->logSuccess($request, $response);

                return $response;
            },
            function (ClientExceptionInterface $exception) use ($request) {
                $this->logError($request, $exception);

                throw $exception;
            }
        );
    }

    private function logSuccess(RequestInterface $request, ResponseInterface $response): void
    {
        $methodAndPath = $request->getMethod() . ' ' . $request->getUri()->getPath();
        $protocol = $response->getProtocolVersion();
        $responseCode = $response->getStatusCode();
        \fprintf($this->output, '<%s HTTP/%s> %s', $methodAndPath, $protocol, $responseCode);
        \fwrite($this->output, "\n");
    }

    private function logError(RequestInterface $request, ClientExceptionInterface $exception): void
    {
        $methodAndPath = $request->getMethod() . ' ' . $request->getUri()->getPath();
        $protocol = $request->getProtocolVersion();
        $error = $exception->getMessage();
        $responseCode = $exception->getCode();
        \fprintf($this->output, '<%s HTTP/%s> %s %s', $methodAndPath, $responseCode, $error, $protocol);
        \fwrite($this->output, "\n");
    }
}