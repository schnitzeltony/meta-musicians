SUMMARY = "C library for storing RDF data in memory"
HOMEPAGE = "http://drobilla.net/software/sord"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=b698a6a2120a83eecb34a9c6f1b93989"

inherit waf pkgconfig

DEPENDS += "libpcre serd"

PV = "0.16.8"
SRC_URI = " \
    http://download.drobilla.net/${BPN}-${PV}.tar.bz2 \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRC_URI[sha256sum] = "7c289d2eaabf82fa6ac219107ce632d704672dcfb966e1a7ff0bbc4ce93f5e14"
