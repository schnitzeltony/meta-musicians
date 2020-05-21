SUMMARY = "LV2 is an open standard for audio plugins"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://COPYING;md5=0383f162366b0c5a316292759a55d292"

SRC_URI = " \
    gitsm://github.com/lv2/lv2.git \
    file://0001-Output-more-details-on-import-error-to-catch-missing.patch \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
S = "${WORKDIR}/git"
SRCREV = "5f40c5c421ffc50783962efb4cab151c8c2519dd"
PV = "1.18.0"

inherit waf pkgconfig
