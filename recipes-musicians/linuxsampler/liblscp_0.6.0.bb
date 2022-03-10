SUMMARY = "LinuxSampler Control Protocol (LSCP) wrapper C library"
HOMEPAGE = "http://www.linuxsampler.org"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=fbc093901857fcd118f065f900982c24 \
"

DEPENDS = " \
"

inherit autotools pkgconfig

SRC_URI = " \
    http://download.linuxsampler.org/packages/${BPN}-${PV}.tar.gz \
    file://0001-Fix-m4-dir.patch \
"
SRC_URI[md5sum] = "ff0fdf2d8b654fc9bfcd32c63d977cd2"
SRC_URI[sha256sum] = "b39c78f4be07d4cc6b791d934e6fe58c0a7bc4aa32b6ed5131e303f99bd687e6"
