SUMMARY = "C library providing simple use of LV2 plugins"
HOMEPAGE = "http://drobilla.net/software/lilv"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=0c6c8928b7dc2190a0aff762ae5a0f64"

inherit waf python3native bash-completion pkgconfig

DEPENDS += "lv2 serd sord sratom"

SRC_URI = " \
    gitsm://github.com/drobilla/lilv.git \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRCREV = "425af428afb969ec2562bdf269967778e067384d"
S = "${WORKDIR}/git"
PV = "0.24.6"
EXTRA_OECONF = "--configdir=${sysconfdir} --dyn-manifest"

PACKAGES += "${PN}-python3"
FILES_${PN}-python3 += "${PYTHON_SITEPACKAGES_DIR}"
RDEPENDS_${PN}-python3 += "python3-core"
