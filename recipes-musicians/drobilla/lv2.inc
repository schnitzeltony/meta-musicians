SUMMARY = "LV2 is an open standard for audio plugins"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://COPYING;md5=0383f162366b0c5a316292759a55d292"

SRC_URI = " \
    gitsm://github.com/drobilla/lv2.git \
    file://0001-Output-more-details-on-import-error-to-catch-missing.patch \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
S = "${WORKDIR}/git"
SRCREV = "06d3f56a39be35b73b7c687920da871b24913edd"
PV = "1.17.0+git${SRCPV}"

inherit waf pkgconfig
