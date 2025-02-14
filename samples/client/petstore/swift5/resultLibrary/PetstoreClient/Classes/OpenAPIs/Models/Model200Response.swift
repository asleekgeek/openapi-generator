//
// Model200Response.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

/** Model for testing model name starting with number */
internal struct Model200Response: Codable, JSONEncodable {

    internal private(set) var name: Int?
    internal private(set) var _class: String?

    internal init(name: Int? = nil, _class: String? = nil) {
        self.name = name
        self._class = _class
    }

    internal enum CodingKeys: String, CodingKey, CaseIterable {
        case name
        case _class = "class"
    }

    // Encodable protocol methods

    internal func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(name, forKey: .name)
        try container.encodeIfPresent(_class, forKey: ._class)
    }
}

