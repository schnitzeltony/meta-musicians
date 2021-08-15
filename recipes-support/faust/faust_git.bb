SUMMARY = "Programming language for signal processing and sound synthesis"
HOMEPAGE = "http://faust.grame.fr/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../COPYING.txt;md5=212be99c180b5dc717a32f58f34ca3fa"

SRC_URI = " \
    gitsm://github.com/grame-cncm/faust.git;protocol=https;branch=master-dev \
    file://0001-Remove-usr-local-include-from-include-path.patch \
"
SRCREV = "e44a4ee922174ecdb02bf64934626dbac597594c"
PV = "2.20.2"
S = "${WORKDIR}/git/build"

inherit cmake

do_install:append() {
    # Failes package QA due to mismatching arch
    rm -rf ${D}${datadir}/faust/android
}

RDEPENDS:${PN} += "bash"

BBCLASSEXTEND = "native"
