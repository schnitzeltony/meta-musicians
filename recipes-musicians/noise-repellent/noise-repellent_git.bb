SUMMARY = "An lv2 plugin for broadband noise reduction"
HOMEPAGE = "https://github.com/lucianodato/noise-repellent"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e6a600fd5e1d9cbde2d983680233ad02"

inherit meson gtk-icon-cache

DEPENDS += " \
    fftw \
    lv2 \
"

PV = "0.1.4+git${SRCPV}"
SRC_URI = " \
    git://github.com/lucianodato/noise-repellent.git \
    file://0001-do-not-pin-sse-flags-they-won-t-work-on-all-arches.patch \
"
SRCREV = "9efdd0b41ec184a792087c87cbf5382f455e33ec"
S = "${WORKDIR}/git"


do_install_append() {
    mkdir -p ${D}${libdir}/lv2
    mv ${D}${prefix}/nrepel.lv2 ${D}${libdir}/lv2/
}

FILES_${PN} += " \
    ${libdir}/lv2 \
"
