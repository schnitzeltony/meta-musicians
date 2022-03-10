SUMMARY = "Musical key detection for digital audio"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/mixxxdj/libkeyfinder.git;branch=main;protocol=https"
SRCREV = "8d4e065ae90f8dbeeded2cc6186767cf99120f8c"
PV = "2.2.5"
S = "${WORKDIR}/git"

DEPENDS = "fftw catch2"

inherit cmake
