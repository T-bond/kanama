package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Low-level hyper-text transfer protocol client.
 *
 * Generated from Godot docs: HTTPClient
 */
class HTTPClient(handle: MemorySegment) : RefCounted(handle) {
    var blockingModeEnabled: Boolean
        @JvmName("blockingModeEnabledProperty")
        get() = isBlockingModeEnabled()
        @JvmName("setBlockingModeEnabledProperty")
        set(value) = setBlockingMode(value)

    var connection: StreamPeer?
        @JvmName("connectionProperty")
        get() = getConnection()
        @JvmName("setConnectionProperty")
        set(value) = setConnection(value)

    var readChunkSize: Int
        @JvmName("readChunkSizeProperty")
        get() = getReadChunkSize()
        @JvmName("setReadChunkSizeProperty")
        set(value) = setReadChunkSize(value)

    /**
     * Connects to a host. This needs to be done before any requests are sent. If no `port` is
     * specified (or `-1` is used), it is automatically set to 80 for HTTP and 443 for HTTPS. You can
     * pass the optional `tls_options` parameter to customize the trusted certification authorities, or
     * the common name verification when using HTTPS. See `TLSOptions.client` and
     * `TLSOptions.client_unsafe`.
     *
     * Generated from Godot docs: HTTPClient.connect_to_host
     */
    fun connectToHost(host: String, port: Int = -1, tlsOptions: TLSOptions?): Long {
        return ObjectCalls.ptrcallWithStringIntObjectArgsRetLong(connectToHostBind, handle, host, port, tlsOptions?.requireOpenHandle() ?: MemorySegment.NULL)
    }

    /**
     * The connection to use for this client.
     *
     * Generated from Godot docs: HTTPClient.set_connection
     */
    fun setConnection(connection: StreamPeer?) {
        ObjectCalls.ptrcallWithObjectArgs(setConnectionBind, handle, listOf(connection?.requireOpenHandle() ?: MemorySegment.NULL))
    }

    /**
     * The connection to use for this client.
     *
     * Generated from Godot docs: HTTPClient.get_connection
     */
    fun getConnection(): StreamPeer? {
        return StreamPeer.wrap(ObjectCalls.ptrcallNoArgsRetObject(getConnectionBind, handle))
    }

    /**
     * Sends a raw HTTP request to the connected host with the given `method`. The URL parameter is
     * usually just the part after the host, so for `https://example.com/index.php`, it is
     * `/index.php`. When sending requests to an HTTP proxy server, it should be an absolute URL. For
     * `HTTPClient.METHOD_OPTIONS` requests, `*` is also allowed. For `HTTPClient.METHOD_CONNECT`
     * requests, it should be the authority component (`host:port`). `headers` are HTTP request
     * headers. Sends the body data raw, as a byte array and does not encode it in any way.
     *
     * Generated from Godot docs: HTTPClient.request_raw
     */
    fun requestRaw(method: Long, url: String, headers: List<String>, body: ByteArray): Long {
        return ObjectCalls.ptrcallWithLongStringPackedStringListByteArrayArgsRetLong(requestRawBind, handle, method, url, headers, body)
    }

    /**
     * Sends an HTTP request to the connected host with the given `method`. The URL parameter is
     * usually just the part after the host, so for `https://example.com/index.php`, it is
     * `/index.php`. When sending requests to an HTTP proxy server, it should be an absolute URL. For
     * `HTTPClient.METHOD_OPTIONS` requests, `*` is also allowed. For `HTTPClient.METHOD_CONNECT`
     * requests, it should be the authority component (`host:port`). `headers` are HTTP request
     * headers. To create a POST request with query strings to push to the server, do:
     *
     * Generated from Godot docs: HTTPClient.request
     */
    fun request(method: Long, url: String, headers: List<String>, body: String = ""): Long {
        return ObjectCalls.ptrcallWithLongStringPackedStringListStringArgsRetLong(requestBind, handle, method, url, headers, body)
    }

    fun closeConnection() {
        ObjectCalls.ptrcallNoArgs(closeConnectionBind, handle)
    }

    /**
     * If `true`, this `HTTPClient` has a response available.
     *
     * Generated from Godot docs: HTTPClient.has_response
     */
    fun hasResponse(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(hasResponseBind, handle)
    }

    /**
     * If `true`, this `HTTPClient` has a response that is chunked.
     *
     * Generated from Godot docs: HTTPClient.is_response_chunked
     */
    fun isResponseChunked(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isResponseChunkedBind, handle)
    }

    /**
     * Returns the response's HTTP status code.
     *
     * Generated from Godot docs: HTTPClient.get_response_code
     */
    fun getResponseCode(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getResponseCodeBind, handle)
    }

    /**
     * Returns the response headers.
     *
     * Generated from Godot docs: HTTPClient.get_response_headers
     */
    fun getResponseHeaders(): List<String> {
        return ObjectCalls.ptrcallNoArgsRetPackedStringList(getResponseHeadersBind, handle)
    }

    /**
     * Returns all response headers as a `Dictionary`. Each entry is composed by the header name, and a
     * `String` containing the values separated by `"; "`. The casing is kept the same as the headers
     * were received.
     *
     * Generated from Godot docs: HTTPClient.get_response_headers_as_dictionary
     */
    fun getResponseHeadersAsDictionary(): Map<String, Any?> {
        return ObjectCalls.ptrcallNoArgsRetDictionary(getResponseHeadersAsDictionaryBind, handle)
    }

    /**
     * Returns the response's body length. Note: Some Web servers may not send a body length. In this
     * case, the value returned will be `-1`. If using chunked transfer encoding, the body length will
     * also be `-1`. Note: This function always returns `-1` on the Web platform due to browsers
     * limitations.
     *
     * Generated from Godot docs: HTTPClient.get_response_body_length
     */
    fun getResponseBodyLength(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getResponseBodyLengthBind, handle)
    }

    /**
     * Reads one chunk from the response.
     *
     * Generated from Godot docs: HTTPClient.read_response_body_chunk
     */
    fun readResponseBodyChunk(): ByteArray {
        return ObjectCalls.ptrcallNoArgsRetByteArray(readResponseBodyChunkBind, handle)
    }

    /**
     * The size of the buffer used and maximum bytes to read per iteration. See
     * `read_response_body_chunk`.
     *
     * Generated from Godot docs: HTTPClient.set_read_chunk_size
     */
    fun setReadChunkSize(bytes: Int) {
        ObjectCalls.ptrcallWithIntArg(setReadChunkSizeBind, handle, bytes)
    }

    /**
     * The size of the buffer used and maximum bytes to read per iteration. See
     * `read_response_body_chunk`.
     *
     * Generated from Godot docs: HTTPClient.get_read_chunk_size
     */
    fun getReadChunkSize(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getReadChunkSizeBind, handle)
    }

    /**
     * If `true`, execution will block until all data is read from the response.
     *
     * Generated from Godot docs: HTTPClient.set_blocking_mode
     */
    fun setBlockingMode(enabled: Boolean) {
        ObjectCalls.ptrcallWithBoolArg(setBlockingModeBind, handle, enabled)
    }

    /**
     * If `true`, execution will block until all data is read from the response.
     *
     * Generated from Godot docs: HTTPClient.is_blocking_mode_enabled
     */
    fun isBlockingModeEnabled(): Boolean {
        return ObjectCalls.ptrcallNoArgsRetBool(isBlockingModeEnabledBind, handle)
    }

    /**
     * Returns a `Status` constant. Need to call `poll` in order to get status updates.
     *
     * Generated from Godot docs: HTTPClient.get_status
     */
    fun getStatus(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(getStatusBind, handle)
    }

    /**
     * This needs to be called in order to have any request processed. Check results with `get_status`.
     *
     * Generated from Godot docs: HTTPClient.poll
     */
    fun poll(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(pollBind, handle)
    }

    /**
     * Sets the proxy server for HTTP requests. The proxy server is unset if `host` is empty or `port`
     * is -1.
     *
     * Generated from Godot docs: HTTPClient.set_http_proxy
     */
    fun setHttpProxy(host: String, port: Int) {
        ObjectCalls.ptrcallWithStringAndIntArg(setHttpProxyBind, handle, host, port)
    }

    /**
     * Sets the proxy server for HTTPS requests. The proxy server is unset if `host` is empty or `port`
     * is -1.
     *
     * Generated from Godot docs: HTTPClient.set_https_proxy
     */
    fun setHttpsProxy(host: String, port: Int) {
        ObjectCalls.ptrcallWithStringAndIntArg(setHttpsProxyBind, handle, host, port)
    }

    /**
     * Generates a GET/POST application/x-www-form-urlencoded style query string from a provided
     * dictionary, e.g.:
     *
     * Generated from Godot docs: HTTPClient.query_string_from_dict
     */
    fun queryStringFromDict(fields: Map<String, Any?>): String {
        return ObjectCalls.ptrcallWithDictionaryArgRetString(queryStringFromDictBind, handle, fields)
    }

    companion object {
        private const val CONNECT_TO_HOST_HASH = 504540374L
        private val connectToHostBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "connect_to_host", CONNECT_TO_HOST_HASH)
        }

        private const val SET_CONNECTION_HASH = 3281897016L
        private val setConnectionBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "set_connection", SET_CONNECTION_HASH)
        }

        private const val GET_CONNECTION_HASH = 2741655269L
        private val getConnectionBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "get_connection", GET_CONNECTION_HASH)
        }

        private const val REQUEST_RAW_HASH = 540161961L
        private val requestRawBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "request_raw", REQUEST_RAW_HASH)
        }

        private const val REQUEST_HASH = 3778990155L
        private val requestBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "request", REQUEST_HASH)
        }

        private const val CLOSE_HASH = 3218959716L
        private val closeConnectionBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "close", CLOSE_HASH)
        }

        private const val HAS_RESPONSE_HASH = 36873697L
        private val hasResponseBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "has_response", HAS_RESPONSE_HASH)
        }

        private const val IS_RESPONSE_CHUNKED_HASH = 36873697L
        private val isResponseChunkedBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "is_response_chunked", IS_RESPONSE_CHUNKED_HASH)
        }

        private const val GET_RESPONSE_CODE_HASH = 3905245786L
        private val getResponseCodeBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "get_response_code", GET_RESPONSE_CODE_HASH)
        }

        private const val GET_RESPONSE_HEADERS_HASH = 2981934095L
        private val getResponseHeadersBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "get_response_headers", GET_RESPONSE_HEADERS_HASH)
        }

        private const val GET_RESPONSE_HEADERS_AS_DICTIONARY_HASH = 2382534195L
        private val getResponseHeadersAsDictionaryBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "get_response_headers_as_dictionary", GET_RESPONSE_HEADERS_AS_DICTIONARY_HASH)
        }

        private const val GET_RESPONSE_BODY_LENGTH_HASH = 3905245786L
        private val getResponseBodyLengthBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "get_response_body_length", GET_RESPONSE_BODY_LENGTH_HASH)
        }

        private const val READ_RESPONSE_BODY_CHUNK_HASH = 2115431945L
        private val readResponseBodyChunkBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "read_response_body_chunk", READ_RESPONSE_BODY_CHUNK_HASH)
        }

        private const val SET_READ_CHUNK_SIZE_HASH = 1286410249L
        private val setReadChunkSizeBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "set_read_chunk_size", SET_READ_CHUNK_SIZE_HASH)
        }

        private const val GET_READ_CHUNK_SIZE_HASH = 3905245786L
        private val getReadChunkSizeBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "get_read_chunk_size", GET_READ_CHUNK_SIZE_HASH)
        }

        private const val SET_BLOCKING_MODE_HASH = 2586408642L
        private val setBlockingModeBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "set_blocking_mode", SET_BLOCKING_MODE_HASH)
        }

        private const val IS_BLOCKING_MODE_ENABLED_HASH = 36873697L
        private val isBlockingModeEnabledBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "is_blocking_mode_enabled", IS_BLOCKING_MODE_ENABLED_HASH)
        }

        private const val GET_STATUS_HASH = 1426656811L
        private val getStatusBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "get_status", GET_STATUS_HASH)
        }

        private const val POLL_HASH = 166280745L
        private val pollBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "poll", POLL_HASH)
        }

        private const val SET_HTTP_PROXY_HASH = 2956805083L
        private val setHttpProxyBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "set_http_proxy", SET_HTTP_PROXY_HASH)
        }

        private const val SET_HTTPS_PROXY_HASH = 2956805083L
        private val setHttpsProxyBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "set_https_proxy", SET_HTTPS_PROXY_HASH)
        }

        private const val QUERY_STRING_FROM_DICT_HASH = 2538086567L
        private val queryStringFromDictBind by lazy {
            ObjectCalls.getMethodBind("HTTPClient", "query_string_from_dict", QUERY_STRING_FROM_DICT_HASH)
        }
    }
}
