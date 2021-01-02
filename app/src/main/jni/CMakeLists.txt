cmake_minimum_required(VERSION 3.4.1)

add_library(native-lib SHARED native-lib.c can.c dsp.c gpio.c mcu.c touch.c uart.c)

target_link_libraries(native-lib android log)