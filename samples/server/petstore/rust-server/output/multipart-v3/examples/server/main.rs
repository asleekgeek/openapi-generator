//! Main binary entry point for multipart_v3 implementation.
// This is the amended version that adds Authorization via Inversion of Control.

#![allow(missing_docs)]


use clap::{App, Arg};

mod server;
mod server_auth;


/// Create custom server, wire it to the autogenerated router,
/// and pass it to the web server.
#[tokio::main]
async fn main() {
    env_logger::init();

    let matches = App::new("server")
        .arg(Arg::with_name("https")
            .long("https")
            .help("Whether to use HTTPS or not"))
        .get_matches();

    let addr = "127.0.0.1:8080";

    server::create(addr, matches.is_present("https")).await;
}
