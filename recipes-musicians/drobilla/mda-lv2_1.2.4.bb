SUMMARY = "MDA-LV2 is an LV2 port of the MDA plugins by Paul Kellett"
HOMEPAGE = "https://drobilla.net/software/mda-lv2"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit waf distro_features_check pkgconfig

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS = "lv2"

SRC_URI = " \
    http://download.drobilla.net/${BPN}-${PV}.tar.bz2 \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRC_URI[md5sum] = "57feb6b58b195f87f8b3e436f3b56076"
SRC_URI[sha256sum] = "a81a00e19594881174526cd6ee7a3e301236e0ca25191982f5c9af5eb8d96ca8"

EXTRA_OECONF = " \
    --lv2dir=${libdir}/lv2 \
"

FILES_${PN} += "${libdir}/lv2"

