SUMMARY = "DrumGizmo drumkit editor"
HOMEPAGE = "https://www.drumgizmo.org"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS += " \
    qttools-native \
    qtbase \
    libao \
    libsndfile1 \
"

inherit autotools-brokensep pkgconfig

SRC_URI = "https://drumgizmo.org/releases/${BPN}-${PV}/${BPN}-${PV}.tar.gz"
SRC_URI[md5sum] = "61c2f87dc2d85325a2ae19d9fbbb62d9"
SRC_URI[sha256sum] = "846f580d5a12eff7e5668893d18547c5a0032d2cf11b9bee37ac7ac094aa83e4"

