SUMMARY = "Jalv is a simple but fully featured LV2 host for Jack"
HOMEPAGE = "http://drobilla.net/software/jalv"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://COPYING;md5=2b0c9f0c37e43f926aac5d7732f06dfb"

inherit waf pkgconfig gtk-icon-cache

DEPENDS += " \
    qtbase-native \
    lv2 \
    lilv \
    serd \
    sord \
    sratom \
    suil \
    jack \
    gtkmm \
    gtk+3 \
    qtbase \
"

SRC_URI = " \
    gitsm://github.com/drobilla/jalv.git \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRCREV = "15f779a8603bc3f020e7000189900c52964771cd"
S = "${WORKDIR}/git"
PV = "1.6.4+git${SRCPV}"

FILES_${PN} += " \
    ${libdir}/jack \
"
