SUMMARY = "C library for RDF syntax which supports accessing Turtle and NTriples"
HOMEPAGE = "http://drobilla.net/software/serd"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=7aceb3a3edc99517b08f5cdd557e11fb"

inherit waf

SRC_URI = " \
    gitsm://github.com/drobilla/serd.git \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRCREV = "2efb107eb4d4381198de51bd4f092ae1ead02e31"
S = "${WORKDIR}/git"
PV = "0.30.3+git${SRCPV}"
