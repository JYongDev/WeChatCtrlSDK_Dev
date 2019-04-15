
cmake_minimum_required(VERSION 3.4.1)


add_library(
            WeChatCtrlSDK

             SHARED

             src/main/cpp/EncryptUtil.cpp
             src/main/cpp/Log.cpp
             src/main/cpp/FileUtil.cpp
             src/main/cpp/MD5.cpp
             src/main/cpp/CtrlSDK.cpp
             src/main/cpp/Download.cpp
             src/main/cpp/httpPostModule.cpp
             src/main/cpp/web_task.cpp
             src/main/cpp/HttpUtil.cpp
              )

include_directories( src/main/cpp/openssl )
include_directories(src/main/cpp/curl)

add_library(crypto STATIC IMPORTED)
set_target_properties(crypto
  PROPERTIES IMPORTED_LOCATION
  ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libcrypto.a)

add_library(ssl STATIC IMPORTED)
set_target_properties(ssl
  PROPERTIES IMPORTED_LOCATION
  ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libssl.a)

add_library(curl STATIC IMPORTED)
set_target_properties(curl
  PROPERTIES IMPORTED_LOCATION
  ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libcurl.a)

find_library( log-lib log
       )


target_link_libraries(  WeChatCtrlSDK
                        crypto
                        ssl
                        curl
                        ${log-lib}
                         )