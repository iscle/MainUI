cmake_minimum_required(VERSION 3.10.2)

add_definitions(-DTHREAD_SLEEP_US=16667)

add_library(native-lib SHARED native-lib.c can.c dsp.c gpio.c mcu.c touch.c uart.c)

target_link_libraries(native-lib android log)