cmake_minimum_required(VERSION 3.22)
project(kanama_android_bootstrap C)

set(CMAKE_C_STANDARD 11)
set(CMAKE_C_STANDARD_REQUIRED ON)

set(KANAMA_ROOT "${CMAKE_CURRENT_SOURCE_DIR}/../../../../../..")

add_library(kanama_bootstrap SHARED
    "${KANAMA_ROOT}/bootstrap/bootstrap.c"
)

target_include_directories(kanama_bootstrap PRIVATE
    "${KANAMA_ROOT}/gdextension"
)

target_link_libraries(kanama_bootstrap PRIVATE
    dl
    log
)
