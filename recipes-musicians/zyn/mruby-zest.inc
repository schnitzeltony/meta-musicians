SUMMARY = "Zyn-Fusion User Interface"
LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = " \
    gitsm://github.com/mruby-zest/mruby-zest-build.git \
    file://0001-mruby-Align-build-to-our-needs.patch \
    file://0002-mruby-zest-Align-build-to-our-needs.patch \
    file://0003-src-osc-bridge-Align-build-to-our-needs.patch \
"
SRCREV = "014e96473bd08768b2e8a05f39ddb406563084b4"
PV = "3.0.5"
PE = "1"
S = "${WORKDIR}/git"

DEPENDS += " \
    ruby-native \
    bison-native \
"

CLEANBROKEN = "1"
