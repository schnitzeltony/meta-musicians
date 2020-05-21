SUMMARY = "C library providing simple use of LV2 plugins"
HOMEPAGE = "http://drobilla.net/software/lilv"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=0c6c8928b7dc2190a0aff762ae5a0f64"

inherit waf python3native bash-completion pkgconfig

DEPENDS += "lv2 serd sord sratom"

SRC_URI = " \
    gitsm://github.com/lv2/lilv.git \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRCREV = "20f2351a859568ca87bf71ef48a9ec4441c156f3"
S = "${WORKDIR}/git"
PV = "0.24.8"
EXTRA_OECONF = "--configdir=${sysconfdir} --dyn-manifest"

PACKAGES += "${PN}-python3"
FILES_${PN}-python3 += "${PYTHON_SITEPACKAGES_DIR}"
RDEPENDS_${PN}-python3 += "python3-core"
