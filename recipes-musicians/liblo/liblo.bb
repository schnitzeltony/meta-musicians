SUMMARY = "liblo is an implementation of the Open Sound Control protocol"
HOMEPAGE = "http://liblo.sourceforge.net"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

inherit autotools pkgconfig

SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz \
"
SRC_URI[md5sum] = "fa1a9d45f86fc18fb54019f670ff2262"
SRC_URI[sha256sum] = "30a7c9de49a25ed7f2425a7a7415f5b14739def62431423d3419ea26fb978d1b"
PV = "0.30"
