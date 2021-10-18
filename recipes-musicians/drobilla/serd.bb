SUMMARY = "C library for RDF syntax which supports accessing Turtle and NTriples"
HOMEPAGE = "http://drobilla.net/software/serd"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=b698a6a2120a83eecb34a9c6f1b93989"

inherit waf pkgconfig

PV = "0.30.8"
SRC_URI = " \
    http://download.drobilla.net/${BPN}-${PV}.tar.bz2 \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRC_URI[sha256sum] = "672ec48f55f6f5bf1b548f3d6a76f127e803dbae2550ddb730bb02d2fd28fa87"
