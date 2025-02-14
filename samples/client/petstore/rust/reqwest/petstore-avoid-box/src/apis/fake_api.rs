/*
 * OpenAPI Petstore
 *
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 * Generated by: https://openapi-generator.tech
 */


use reqwest;
use serde::{Deserialize, Serialize};
use crate::{apis::ResponseContent, models};
use super::{Error, configuration};

/// struct for passing parameters to the method [`test_nullable_required_param`]
#[derive(Clone, Debug)]
pub struct TestNullableRequiredParamParams {
    /// The name that needs to be fetched. Use user1 for testing.
    pub user_name: String,
    /// To test nullable required parameters
    pub dummy_required_nullable_param: Option<String>,
    pub any_type: String,
    /// To test parameter names in upper case
    pub uppercase: Option<String>,
    /// To test escaping of parameters in rust code works
    pub content: Option<String>
}


/// struct for typed successes of method [`test_nullable_required_param`]
#[derive(Debug, Clone, Serialize, Deserialize)]
#[serde(untagged)]
pub enum TestNullableRequiredParamSuccess {
    Status200(),
    UnknownValue(serde_json::Value),
}

/// struct for typed errors of method [`test_nullable_required_param`]
#[derive(Debug, Clone, Serialize, Deserialize)]
#[serde(untagged)]
pub enum TestNullableRequiredParamError {
    Status400(),
    Status404(),
    UnknownValue(serde_json::Value),
}


/// 
pub async fn test_nullable_required_param(configuration: &configuration::Configuration, params: TestNullableRequiredParamParams) -> Result<ResponseContent<TestNullableRequiredParamSuccess>, Error<TestNullableRequiredParamError>> {

    let uri_str = format!("{}/fake/user/{user_name}", configuration.base_path, user_name=crate::apis::urlencode(params.user_name));
    let mut req_builder = configuration.client.request(reqwest::Method::GET, &uri_str);

    if let Some(ref param_value) = params.content {
        req_builder = req_builder.query(&[("content", &param_value.to_string())]);
    }
    req_builder = req_builder.query(&[("anyType", &params.any_type.to_string())]);
    if let Some(ref user_agent) = configuration.user_agent {
        req_builder = req_builder.header(reqwest::header::USER_AGENT, user_agent.clone());
    }
    match params.dummy_required_nullable_param {
        Some(param_value) => { req_builder = req_builder.header("dummy_required_nullable_param", param_value.to_string()); },
        None => { req_builder = req_builder.header("dummy_required_nullable_param", ""); },
    }
    if let Some(param_value) = params.uppercase {
        req_builder = req_builder.header("UPPERCASE", param_value.to_string());
    }

    let req = req_builder.build()?;
    let resp = configuration.client.execute(req).await?;

    let status = resp.status();

    if !status.is_client_error() && !status.is_server_error() {
        let content = resp.text().await?;
        let entity: Option<TestNullableRequiredParamSuccess> = serde_json::from_str(&content).ok();
        Ok(ResponseContent { status, content, entity })
    } else {
        let content = resp.text().await?;
        let entity: Option<TestNullableRequiredParamError> = serde_json::from_str(&content).ok();
        Err(Error::ResponseError(ResponseContent { status, content, entity }))
    }
}

