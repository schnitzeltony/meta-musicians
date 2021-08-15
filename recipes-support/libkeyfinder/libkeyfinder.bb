SUMMARY = "Musical key detection for digital audio"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/mixxxdj/libkeyfinder.git;branch=main;protocol=https"
SRCREV = "99c59aa4eb68071cb5ac8ce0944247a88d417143"
PV = "2.2.4"
S = "${WORKDIR}/git"

DEPENDS = "fftw"

inherit cmake

FILES_SOLIBSDEV = ""
FILES:${PN} += " \
    ${libdir}/libkeyfinder.so \
"
