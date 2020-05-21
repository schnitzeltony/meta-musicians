SUMMARY = "MDA-LV2 is an LV2 port of the MDA plugins by Paul Kellett"
HOMEPAGE = "https://drobilla.net/software/mda-lv2"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit waf features_check pkgconfig

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS = "lv2"

SRC_URI = " \
    gitsm://gitlab.com/drobilla/mda-lv2.git;protocol=https \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRCREV = "1761c1c97a4a4b9b5dc1bbb5b2784bafa8c7d2d5"
PV = "1.2.4"
S = "${WORKDIR}/git"

EXTRA_OECONF = " \
    --lv2dir=${libdir}/lv2 \
"

FILES_${PN} += "${libdir}/lv2"

