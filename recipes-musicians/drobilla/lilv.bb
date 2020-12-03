SUMMARY = "C library providing simple use of LV2 plugins"
HOMEPAGE = "http://drobilla.net/software/lilv"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=c06b907cf23a6e8b605bfb2b0d2446cc"

inherit waf python3native bash-completion pkgconfig

DEPENDS += "lv2 serd sord sratom"

PV = "0.24.10"
SRC_URI = " \
    http://download.drobilla.net/${BPN}-${PV}.tar.bz2 \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRC_URI[sha256sum] = "d1bba93d6ddacadb5e742fd10ad732727edb743524de229c70cc90ef81ffc594"

EXTRA_OECONF = "--configdir=${sysconfdir} --dyn-manifest"

PACKAGES += "${PN}-python3"
FILES_${PN}-python3 += "${PYTHON_SITEPACKAGES_DIR}"
RDEPENDS_${PN}-python3 += "python3-core"
