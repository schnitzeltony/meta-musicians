SUMMARY = "C library providing simple use of LV2 plugins"
HOMEPAGE = "http://drobilla.net/software/lilv"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=b698a6a2120a83eecb34a9c6f1b93989"

inherit waf python3native bash-completion pkgconfig

DEPENDS += "lv2 serd sord sratom"

PV = "0.24.12"
SRC_URI = " \
    http://download.drobilla.net/${BPN}-${PV}.tar.bz2 \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRC_URI[sha256sum] = "26a37790890c9c1f838203b47f5b2320334fe92c02a4d26ebbe2669dbd769061"

EXTRA_OECONF = "--configdir=${sysconfdir} --dyn-manifest"

PACKAGES += "${PN}-python3"
FILES:${PN}-python3 += "${PYTHON_SITEPACKAGES_DIR}"
RDEPENDS:${PN}-python3 += "python3-core"
