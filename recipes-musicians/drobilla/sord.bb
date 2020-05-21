SUMMARY = "C library for storing RDF data in memory"
HOMEPAGE = "http://drobilla.net/software/sord"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=6b8d060e6d32fbd53684f9dc0443b6a3"

inherit waf pkgconfig

DEPENDS += "libpcre serd"

SRC_URI = " \
    gitsm://gitlab.com/drobilla/sord.git;protocol=https \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRCREV = "834610cd3faceff24c083738dbe88a56d412368c"
S = "${WORKDIR}/git"
PV = "0.16.4+git${SRCPV}"
