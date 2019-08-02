SUMMARY = "Suil is a lightweight C library for loading and wrapping LV2 plugin UIs"
HOMEPAGE = "https://drobilla.net/software/suil"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=31b283049b7bf3fc441d62cd43d8f4b9"

inherit waf distro_features_check pkgconfig

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS = "gtk+ gtk+3 qtbase lv2"

SRC_URI = "http://download.drobilla.net/${BPN}-${PV}.tar.bz2"
SRC_URI[md5sum] = "b5a0ccb70ec0791531ee69f3a5b86ab6"
SRC_URI[sha256sum] = "a1e9899012790eef8867b5475853d76689b246cca88a99ac0d379a6c0d85c72b"

FILES_${PN} += "${libdir}/suil-0"
