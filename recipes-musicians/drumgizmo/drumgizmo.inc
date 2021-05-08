SUMMARY = "DrumGizmo is drum plugin and stand-alone application"
HOMEPAGE = "https://www.drumgizmo.org"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=e6a600fd5e1d9cbde2d983680233ad02"

SRC_URI = " \
    http://www.drumgizmo.org/releases/${BPN}-${PV}/${BPN}-${PV}.tar.gz \
    file://0001-Fix-build-with-gcc11.patch \
"
SRC_URI[sha256sum] = "7426f38b58fbb82d3eada60c204d74e6c5de31ef424c017e3f890117e146a2a3"
PV = "0.9.19"
