SUMMARY = "A free software percussion synthesizer"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

inherit cmake mime mime-xdg gtk-icon-cache

DEPENDS += " \
    redkite \
    redkite-native \
    libsndfile1 \
    rapidjson \
    jack \
    lv2 \
"

SRC_URI = " \
    git://gitlab.com/iurie-sw/geonkick;protocol=https \
    file://0001-Fix-build-for-ARM.patch \
"
SRCREV = "3fe23d258440b4acc690044439720f01f51ac754"
PV = "2.3.2"
S = "${WORKDIR}/git"

EXTRA_OECMAKE = " \
    -DCMAKE_BUILD_TYPE=RelWithDebInfo \
    -DGKICK_ARCHITECTURE=${TARGET_ARCH} \
"

FILES_${PN} += " \
    ${datadir}/mime \
    ${libdir}/lv2 \
"
