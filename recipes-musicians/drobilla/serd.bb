SUMMARY = "C library for RDF syntax which supports accessing Turtle and NTriples"
HOMEPAGE = "http://drobilla.net/software/serd"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=7aceb3a3edc99517b08f5cdd557e11fb"

inherit waf

SRC_URI = " \
    gitsm://gitlab.com/drobilla/serd.git;protocol=https \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRCREV = "227565f5be637d4d5db231f8860ee24c610ddad7"
S = "${WORKDIR}/git"
PV = "0.30.4"
