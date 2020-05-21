SUMMARY = "Suil is a lightweight C library for loading and wrapping LV2 plugin UIs"
HOMEPAGE = "https://drobilla.net/software/suil"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=31b283049b7bf3fc441d62cd43d8f4b9"

inherit waf features_check pkgconfig

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS = "gtk+ gtk+3 qtbase lv2"

SRC_URI = " \
    gitsm://github.com/lv2/suil.git \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRCREV = "5d45fda230192d47a4afadecdf3dce038b8d6fe9"
S = "${WORKDIR}/git"
PV = "0.10.6+git${SRCPV}"

FILES_${PN} += "${libdir}/suil-0"
