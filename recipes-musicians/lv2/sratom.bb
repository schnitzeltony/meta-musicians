SUMMARY = "Sratom is a library for serialising LV2 atoms to and from RDF"
HOMEPAGE = "http://drobilla.net/software/sratom"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=ebc7934238811c788037421c6c548ddf"

inherit waf pkgconfig

DEPENDS += "lv2 serd sord"

SRC_URI = " \
    gitsm://github.com/lv2/sratom.git \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRCREV = "2a585c391df6d8d9b0c92e850eab891b6a8f74f3"
S = "${WORKDIR}/git"
PV = "0.6.4+git${SRCPV}"

