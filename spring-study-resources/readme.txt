参考链接：
https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/core.html#resources

Resources

2.1. Introduction
Java’s standard java.net.URL class and standard handlers for various URL prefixes 
unfortunately are not quite adequate enough for all access to low-level resources. 
For example, there is no standardized URL implementation that may be used to access 
a resource that needs to be obtained from the classpath, or relative to a 
ServletContext. While it is possible to register new handlers for specialized URL 
prefixes (similar to existing handlers for prefixes such as http:), this is generally 
quite complicated, and the URL interface still lacks some desirable functionality, 
such as a method to check for the existence of the resource being pointed to.


2.2. The Resource interface

getInputStream(): locates and opens the resource, returning an InputStream for reading from the resource. It is expected that each invocation returns a fresh InputStream. It is the responsibility of the caller to close the stream.

exists(): returns a boolean indicating whether this resource actually exists in physical form.

isOpen(): returns a boolean indicating whether this resource represents a handle with an open stream. If true, the InputStream cannot be read multiple times, and must be read once only and then closed to avoid resource leaks. Will be false for all usual resource implementations, with the exception of InputStreamResource.

getDescription(): returns a description for this resource, to be used for error output when working with the resource. This is often the fully qualified file name or the actual URL of the resource.

2.3. Built-in Resource implementations

2.4. The ResourceLoader

2.5. The ResourceLoaderAware interface
## 不够理解

2.6. Resources as dependencies

2.7. Application contexts and Resource paths



