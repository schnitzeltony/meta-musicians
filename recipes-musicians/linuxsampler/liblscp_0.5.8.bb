SUMMARY = "LinuxSampler Control Protocol (LSCP) wrapper C library"
HOMEPAGE = "http://www.linuxsampler.org"
LICENSE = "LGPLv2.1"
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
SRC_URI[md5sum] = "c9ef8ba50765784b544904b854c68c00"
SRC_URI[sha256sum] = "b611943f2f81fc58ff6852adfb2ee60789becbd3eda7ca65d300d9c0a7538e01"
