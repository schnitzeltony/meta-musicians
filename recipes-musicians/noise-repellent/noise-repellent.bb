SUMMARY = "An lv2 plugin for broadband noise reduction"
HOMEPAGE = "https://github.com/lucianodato/noise-repellent"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e6a600fd5e1d9cbde2d983680233ad02"

inherit meson pkgconfig gtk-icon-cache

DEPENDS += " \
    lv2 \
    libspecbleach \
"

PV = "0.2.3"
SRC_URI = " \
    git://github.com/lucianodato/noise-repellent.git;branch=master;protocol=https \
    file://0001-do-not-pin-sse-flags-they-won-t-work-on-all-arches.patch \
"
SRCREV = "6f2d6074fcf7c599450369c4f2132c2ce097a422"
S = "${WORKDIR}/git"

FILES:${PN} += " \
    ${libdir}/lv2 \
"
