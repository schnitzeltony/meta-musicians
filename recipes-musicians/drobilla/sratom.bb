SUMMARY = "Sratom is a library for serialising LV2 atoms to and from RDF"
HOMEPAGE = "http://drobilla.net/software/sratom"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=02c12fd13bfe8cd6878ad1ea35778acf"

inherit waf pkgconfig

DEPENDS += "lv2 serd sord"

PV = "0.6.8"
SRC_URI = " \
    http://download.drobilla.net/${BPN}-${PV}.tar.bz2 \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRC_URI[sha256sum] = "3acb32b1adc5a2b7facdade2e0818bcd6c71f23f84a1ebc17815bb7a0d2d02df"
