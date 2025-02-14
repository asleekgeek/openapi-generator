/*
 * OpenAPI Petstore
 *
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 * Generated by: https://openapi-generator.tech
 */


use async_trait::async_trait;
#[cfg(feature = "mockall")]
use mockall::automock;
use reqwest;
use std::sync::Arc;
use serde::{Deserialize, Serialize};
use crate::{apis::ResponseContent, models};
use super::{Error, configuration};

#[cfg_attr(feature = "mockall", automock)]
#[async_trait]
pub trait FakeApi: Send + Sync {

    /// GET /fake/user/{user_name}
    async fn test_nullable_required_param<'user_name, 'dummy_required_nullable_param, 'any_type, 'uppercase, 'content>(&self, user_name: &'user_name str, dummy_required_nullable_param: Option<&'dummy_required_nullable_param str>, any_type: &'any_type str, uppercase: Option<&'uppercase str>, content: Option<&'content str>) -> Result<(), Error<TestNullableRequiredParamError>>;
}

pub struct FakeApiClient {
    configuration: Arc<configuration::Configuration>
}

impl FakeApiClient {
    pub fn new(configuration: Arc<configuration::Configuration>) -> Self {
        Self { configuration }
    }
}



#[async_trait]
impl FakeApi for FakeApiClient {
    /// 
    async fn test_nullable_required_param<'user_name, 'dummy_required_nullable_param, 'any_type, 'uppercase, 'content>(&self, user_name: &'user_name str, dummy_required_nullable_param: Option<&'dummy_required_nullable_param str>, any_type: &'any_type str, uppercase: Option<&'uppercase str>, content: Option<&'content str>) -> Result<(), Error<TestNullableRequiredParamError>> {
        let local_var_configuration = &self.configuration;

        let local_var_client = &local_var_configuration.client;

        let local_var_uri_str = format!("{}/fake/user/{user_name}", local_var_configuration.base_path, user_name=crate::apis::urlencode(user_name));
        let mut local_var_req_builder = local_var_client.request(reqwest::Method::GET, local_var_uri_str.as_str());

        if let Some(ref local_var_str) = content {
            local_var_req_builder = local_var_req_builder.query(&[("content", &local_var_str.to_string())]);
        }
        local_var_req_builder = local_var_req_builder.query(&[("anyType", &any_type.to_string())]);
        if let Some(ref local_var_user_agent) = local_var_configuration.user_agent {
            local_var_req_builder = local_var_req_builder.header(reqwest::header::USER_AGENT, local_var_user_agent.clone());
        }
        match dummy_required_nullable_param {
            Some(local_var_param_value) => { local_var_req_builder = local_var_req_builder.header("dummy_required_nullable_param", local_var_param_value.to_string()); },
            None => { local_var_req_builder = local_var_req_builder.header("dummy_required_nullable_param", ""); },
        }
        if let Some(local_var_param_value) = uppercase {
            local_var_req_builder = local_var_req_builder.header("UPPERCASE", local_var_param_value.to_string());
        }

        let local_var_req = local_var_req_builder.build()?;
        let local_var_resp = local_var_client.execute(local_var_req).await?;

        let local_var_status = local_var_resp.status();
        let local_var_content = local_var_resp.text().await?;

        if !local_var_status.is_client_error() && !local_var_status.is_server_error() {
            Ok(())
        } else {
            let local_var_entity: Option<TestNullableRequiredParamError> = serde_json::from_str(&local_var_content).ok();
            let local_var_error = ResponseContent { status: local_var_status, content: local_var_content, entity: local_var_entity };
            Err(Error::ResponseError(local_var_error))
        }
    }

}

/// struct for typed errors of method [`test_nullable_required_param`]
#[derive(Debug, Clone, Serialize, Deserialize)]
#[serde(untagged)]
pub enum TestNullableRequiredParamError {
    Status400(),
    Status404(),
    UnknownValue(serde_json::Value),
}

