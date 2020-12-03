SUMMARY = "C library for RDF syntax which supports accessing Turtle and NTriples"
HOMEPAGE = "http://drobilla.net/software/serd"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=c06b907cf23a6e8b605bfb2b0d2446cc"

inherit waf

PV = "0.30.6"
SRC_URI = " \
    http://download.drobilla.net/${BPN}-${PV}.tar.bz2 \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRC_URI[sha256sum] = "f5a2c74c659d8b318059068f135a43a3771491c367b6947e053a713b23cd37ef"
